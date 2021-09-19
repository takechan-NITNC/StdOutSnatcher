# アクセス
- public
# 継承元
- java.io.ByteArrayInputStream
# フィールド
## protected ByteArrayOutputStream byteArrayOutputStream
標準出力の出力先
## protected PrintStream nativePrintStream
デフォルトの標準出力
## protected PrintStream newPrintStream
byteArrayOutputStreamを出力先とした標準出力
## protected byte[] buf
標準出力の内容を記憶します．
## protected int count
buf内の有効な要素数
## protected int mark
buf内のマークがあるインデックス
## protected int pos
buf内の次に読み取られるインデックス
# メソッド
## public StdOutSnatcher()
bufを要素数０の配列で初期化し，標準出力の出力先をnewPrintStreamに変更します．
## protected void update()
bufをbyteArrayOutputStream.toByteArray()に更新し，countをbuf.lengthに更新します．
## public int available()
bufとcountをbyteArrayOutputStreamの内容に更新し，この入力ストリームから読み込める残りのバイト数を返します．
## public void close()
bufにnullを代入し，newPrintStreamを閉じます．
## public void mark(int readAheadLimit)
java.io.ByteArrayInputStreamから継承
## public boolean markSupported()
常にtrueを返します．
## public int read()
bufとcountをbyteArrayOutputStreamの内容に更新し，入力ストリームの次のバイトを読み込んで返します．入力ストリームの末端に達している場合は-1を返します．
## public int read(byte[] array, int offset, int length)
bufとcountをbyteArrayOutputStreamの内容に更新し，入力ストリームの内容をarrayのoffsetインデックスから順に，最大length個の範囲に格納します．途中で入力ストリームの末端に達した場合はそこで処理を中止します．最初から入力ストリームの末端に達していた場合は-1を返し，そうでない場合は実際に読み込まれた要素の個数を返します．
## public void reset()
java.io.ByteArrayInputStreamから継承
## public long skip(long distance)
bufとcountをbyteArrayOutputStreamの内容に更新し，入力ストリームをdistanceだけスキップします．スキップ途中で入力ストリームの末端に達した場合はそこで処理を中止します．返す値は実際にスキップされた距離です．
## public int read(byte[] array) throws IOException
bufとcountをbyteArrayOutputStreamの内容に更新し，入力ストリームの内容をarrayに格納します．途中で入力ストリームの末端に達した場合はそこで処理を中止します．最初から入力ストリームの末端に達していた場合は-1を返し，そうでない場合は実際に読み込まれた要素の個数を返します．
## protected Object clone() throws CloneNotSupportedException
CloneNotSupportedExceptionをスローします．
## public boolean equals(Object object)
このインスタンスとobjectが同じクラスのインスタンスでないか，objectがnullの場合，falseを返します．そうでない場合，bufの内容・mark・posがどれも等しいならtrue，１つでも等しくないならfalseを返します．
## protected void finalize() throws Throwable
標準出力をデフォルトに戻します．
## public final Class<?> getClass()
このインスタンスが何のクラスのものなのかを返します．
## public int hashCode()
bufの内容・mark・posを基にしたハッシュ値を返します．
## public final void notify()
java.lang.Objectから継承
## public final void notifyAll()
java.lang.Objectから継承
## public final void wait() throws InterruptedException
java.lang.Objectから継承
## public final void wait(long timeout) throws InterruptedException
java.lang.Objectから継承
## public final void wait(long timeout, int nanos) throws InterruptedException
java.lang.Objectから継承