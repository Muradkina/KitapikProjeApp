package com.kitaplik.libraryservice.exception;


/*Record sınıfları, Java 16 ve sonraki sürümlerde yer alan bir tür veri yapısıdır ve
genellikle veri tutmak için kullanılır.
Bu örnekteki "ExceptionMessage" kayıt sınıfı, bir istisna durumu için temel bilgileri içeren
bir veri yapısı tanımlamak için kullanılır
Sınıfın alanları, istisna durumunun oluştuğu zamana, durum koduna, hatanın türüne, hatanın ayrıntılarına ve istisna
durumunun meydana geldiği yere (yani istek yoluna) ilişkin bilgileri içerir.
*/
public record ExceptionMessage(String timestamp,
                               int status,
                               String error,
                               String message,
                               String path) {
}
//record   biziç için jwm de final class oluşturur. içinde consructor ve get medodları olur
//record bize full şekilde immutable nesne üretir
//record entitiylerde kulllanmayız çünkü boş coonsroctor yok ve extend edilemıo