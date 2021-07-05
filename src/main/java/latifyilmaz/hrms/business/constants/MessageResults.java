package latifyilmaz.hrms.business.constants;

import java.util.HashMap;
import java.util.Map;

public class MessageResults {
    public static final Map<String, String> models = new HashMap<>();

    static {
        models.put("email", "E-Posta");
        models.put("password", "Şifre");
        models.put("identityNo", "TC Kimlik NO");
        models.put("user", "Kullanıcı");
        models.put("personnel", "Personel");
        models.put("employer", "İşveren");
        models.put("employee", "Çalışan");
        models.put("position", "İş Pozisyonu");
        models.put("city", "Şehir");
        models.put("workingTime", "Çalışma Şekli");
        models.put("jobAdvertisement", "İş İlanı");
        models.put("resume", "Özgeçmiş");
        models.put("school", "Okul");
        models.put("jobExperience", "İş tecrübesi");
        models.put("language", "Dil");
        models.put("ability", "Beceri");
        models.put("image", "Resim");
    }

    public static final String emptyField = "Lütfen bu alanı boş bırakmayın!";
    public static final String emptyFields = "Lütfen bu alanları boş bırakmayın!";
    public static final String oldPasswordMatchFalse = "Eski Şifre doğru değil!";
    public static final String passwordMatchFalse = "Şifreler eşleşmiyor!";
    public static final String newPasswordMatchFalse = "Yeni Şifreler eşleşmiyor!";
    public static final String errorLogin = "Email veya Şifre doğru değil. Tekrardan deneyin!";
    public static final String successLogin = "Giriş başarılı! Anasayfaya yönlendiriliyorsunuz.";
    public static final String verificationSuccessFalse = "Doğrulama işlemi başarısız!";
    public static final String unverificationSuccessFalse = "Doğrulama kaldırma işlemi başarısız!";
    public static final String verificationSuccessTrue = "Doğrulama işlemi başarılı!";
    public static final String unverificationSuccessTrue = "Doğrulama kaldırma işlemi başarılı!";
    public static final String isRealPersonFalse = "Kimlik doğrulanamadı! Lütfen bilgilerinizi doğru girdiğinizden emin olunuz.";
    public static final String isEmailFormatFalse = "E-Posta formatı yanlış. Lütfen 'ornek@ornek.com' formatına uygun bir e-posta giriniz.";
    public static final String validateEmail = "Kaydınızın tamamlanması için E-Postanıza gelecek olan aktivasyonu gerçekleştirmeniz gerek.";
    public static final String validateEmailBySystem = "Kaydınız sistemimiz tarafından en kısa sürede onaylanacaktır. Sabrınız için teşekkür ederiz.";
    public static final String errorWhileUploadingFile = "Dosya yüklenirken bir sorunla karşılaşıldı!";
    public static final String error = "Maalesef bir hata oluştu.";
    public static String alreadyExists(String model){
        return String.format("Bu %s zaten kayıtlı. Başka birini deneyiniz.", models.get(model)); //
    }

    public static String notFound(String model){
        return String.format("Böyle bir %s kaydı bulunamadı.", models.get(model));
    }

    public static String allDataListed(String model){
        return String.format("Tüm %s verileri listelendi.", models.get(model));
    }

    public static String dataListed(String model){
        return String.format("%s verisi listelendi.", models.get(model));
    }

    public static String saved(String model){
        return String.format("%s sisteme başarıyla eklendi.", models.get(model));
    }

    public static String successfullySaved(String model){
        return String.format("%s başarıyla kaydedildi.", models.get(model));
    }

    public static String saved(String model, String extraText){
        return String.format("%s kaydı sisteme başarıyla eklendi. %s", models.get(model), extraText);
    }

    public static String deleted(String model){
        return String.format("%s sistemden başarıyla silindi.", models.get(model));
    }

    public static String deleteds(String model){
        return String.format("%s verileri sistemden başarıyla silindi.", models.get(model));
    }

    public static String updated(String model){
        return String.format("%s sistemde başarıyla güncellendi.", models.get(model));
    }

    public static String emailSent(String email){
        return String.format("E-Posta başarıyla gönderildi: %s", email);
    }

}
