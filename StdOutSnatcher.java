import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
public class StdOutSnatcher extends ByteArrayInputStream {
	protected ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	protected PrintStream nativePrintStream = System.out;
	protected PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);
	public StdOutSnatcher() {
		super(new byte[0]);
		System.setOut(this.newPrintStream);
	}
	protected void update() {
		this.buf = byteArrayOutputStream.toByteArray();
		this.count = this.buf.length;
	}
	@Override public int available() {
		this.update();
		return super.available();
	}
	@Override public void close() {
		this.buf = null;
		this.newPrintStream.close();
	}
	@Override public int read() {
		this.update();
		return super.read();
	}
	@Override public int read(byte[] array, int offset, int length) {
		this.update();
		return super.read(array, offset, length);
	}
	@Override public long skip(long distance) {
		this.update();
		return super.skip(distance);
	}
	@Override public int read(byte[] array) throws IOException {
		return this.read(array, 0, array.length);
	}
	@Override public boolean equals(Object object) {
		if(!this.getClass().getName().equals(object.getClass().getName()) || object == null) {
			return false;
		}
		final StdOutSnatcher CASTED_OBJECT = (StdOutSnatcher)object;
		return Arrays.equals(this.buf, CASTED_OBJECT.buf) && this.mark == CASTED_OBJECT.mark && this.pos == CASTED_OBJECT.pos;
	}
	@Override protected void finalize() throws Throwable {
		System.setOut(this.nativePrintStream);
	}
	@Override public int hashCode() {
		return Arrays.hashCode(this.buf) / 3 + Integer.hashCode(this.mark) / 3 + Integer.hashCode(this.pos) / 3;
	}
	@Override public String toString() {
		return Arrays.toString(Arrays.copyOfRange(this.buf, this.pos, this.buf.length));
	}
}