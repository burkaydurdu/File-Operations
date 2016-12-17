# Java Dosya Islemleri

 Java Dosya islemleri  giris/cikis islemleri olarak niteledigimiz bir olay olup, bir dosyadan verileri okumak veya bir dosyaya verileri yazmak icin kullanilir.
 Giris cikis islemlerini java'da gerceklestirmek icin **java.io** paketini projemize eklememiz gerekiyor.
 > `import java.io.*;`

 Java'da veri aktarim islemleri, **karakter bazli** ve **byte bazli** olarak ikiye ayrilir.Karakter bazli aktarim islemi,verileri karakterler halinde ulastirir ilgili yere **unicode**_(diger alfabeleri destekleme)_ destegi vardir. Byte bazli aktarim isleminde ise karakter topluluklari halinde aktarim yapilir. Bu yontem karakter tabanliya gore performans orani daha yuksektir.
