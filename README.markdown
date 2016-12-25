# Java Dosya İşlemleri

 Java Dosya işlemleri  giriş/cıkış işlemleri olarak nitelediğimiz bir olay olup, bir dosyadan verileri okumak veya bir dosyaya verileri yazmak için kullanılır.
 Giriş cıkış işlemlerini java'da gerçekleştirmek için **java.io** paketini projemize eklememiz gerekiyor.
 > `import java.io.*;`

 Java'da veri aktarım işlemleri, **karakter bazlı** ve **byte bazlı** olarak ikiye ayrilir.Karakter bazli aktarim islemi,verileri karakterler halinde ulaştırır ilgili yere **unicode**_(diğer alfabeleri destekleme)_ desteği vardır. Byte bazli aktarim isleminde ise karakter topluluklari halinde aktarim yapilir. Bu yontem karakter tabanliya gore performans oranı daha yuksektir.
 Karakter tabanlı verı ıletimi **Writer** ve **Reader** sınıfları ile yapılır. Bu sınıflarda kendi içinde sınıflara ayrılırlar.
> Reader:
> *  InputStreamReader
> *  BufferedReader
> *  FileReader
> *  FilterReader
> *  StringReader

> Writer:
> *  OutputStreamWriter
> *  BufferedWriter
> *  FileWriter
> *  FilterWriter
> *  StringWriter
> *  PrintWriter


  Global :
```
   private FileReader fileReader = null;
   private FileWriter fileWriter = null;
```
  function Writer:
```
   fileWriter = new FileWriter(file);
   for(char character : dat)
   fileWriter.write(character);
   fileWriter.close();
```
  function Reader:
```
  fileReader = new FileReader(file);
  while((character = (int) fileReader.read())!=-1)
  data+=(char)character;
  fileReader.close();
```
  **fileWriter** ile karakter karakter yazdırdık dosyamıza burda _dat_ char dizisi türünde bir degişken,  burada **int**, **String** ve **char[]**  turundede verebiliyoruz. **A** yazilicaksa a'nin ascii karşılıgını verirsek bunu o degerin karsılık geldiği karakteri dosyaya yazar. Bizim burda yaptığımız şey, asci değeri vermedik, karakter karşılığını yazdık.
  **fileReader** ile karakterler okunuyor ``while`` icinde satir sonuna gelene kadar. Burda karakterler ascii kodlama ile degerleri okunup karaktere iz dusuruluyor. character int tipinde ve data string tipindedir.

  Byte tabanli veri iletimi **InputStream** ve **OutputStream** siniflari yardimiyla yapilir. Byte bazli islemlerde, okunan veriler byte tipinde bir diziye aktarilir.

> InputStream:
> * BufferedInputStream
> * DataInputStream
> * FilterInputStream
> * PrintStream
> * RandomAccessFile
> * FileInputStream

> OutputStream
> * BufferedOutputStream
> * DataOutputStream
> * FilterOutputStream

   Global:
```
  private FileOutputStream outputStream = null;
  private FileInputStream inputStream = null;
```

   function Writer:  
```
  outputStream = new FileOutputStream(file);
  for(char dat : Data)  
  outputStream.write(dat);  
  outputStream.close();

```

  function Reader:
```
  inputStream= new FileInputStream(file);
  while((dat=(byte)inputStream.read())!=-1)
  data+=(char)dat;
  inputStream.close();

```
  **outputStream** ile bayt tabanli olarak veriler yaziyoruz dosyaya. Burada karakter char olarak yazdik aslinda bu char tipini bayt  cevirip dosyaya yaziyor, dosyadada bu karaktere iz dusurulerek gosterilir. Biz burada bayt dizisi veripte verileri yazdira bilirdik. String tipinde verinizi byte dizisine cevirip dosyaya yazabilirsiniz, bunu saglayan ``getBytes()`` fonksiyonudur.
  **inputStream** ile  bayt olarak gelen verileri bir byte tipindeki degiskene atayip, sonra onu char ile cast ederek ekrana bastirdik.

  Suana  kadar yaptigimiz islemlerde ya byte byte  okuduk yazdik yada karakter karakter bunlar performans olarak  dusuktur. Bunu guclendirmek icin  Reader ve Writer siniflarindan tureyen BufferedReader ve BufferedWriter  siniflarina bakicaz bunlar karakter tabanli islemler yaparlar ve buffer kullanirlar, bu performansi artirir.


  Global:
```
  private BufferedReader bufferedReader = null;
  private BufferedWriter bufferedWriter = null;
```

  function Writer :
```
  fileWriter = new FileWriter(file);
  bufferedWriter = new BufferedWriter(fileWriter);
  bufferedWriter.write(Data);
  bufferedWriter.close();
  fileWriter.close();

```

  function Reader:
```
  fileReader = new FileReader(file);
  bufferedReader = new BufferedReader(fileReader);
  while((dat = bufferedReader.readLine())!=null)
  data.append(dat);
  bufferedReader.close();
  fileReader.close();

```
  Burada tek fark olarak  karakter tabanli oldugu icin buffer yapicilarina  **fileReader** ve **fileWriter** nesnelerini veriyoruz. Buffer kullandigimiz icin verileri hizli yazar ve okuruz.
  Buffer dedigimiz olay ise hizli bellekte bir tampon gibi dusunulebilir diske yazmak yerine  buffer'a yazilir okunucaksa burdan hizlica okunur. Islemler bitince bufferdan diske yazilir veri. Eger bufferdan diske yazilmasini beklemek istemiyorsak ``flush()`` fonksiyonu cagrilarak bu islemi elle tetikleyebiliriz.
