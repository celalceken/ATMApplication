package cc.atm.veritabani;


import cc.atm.Araclar;
import cc.atm.IVeritabaniRepository;
import cc.atm.MusteriHesabi;

public class SanalVeritabaniSurucu implements IVeritabaniRepository {
    @Override
    public MusteriHesabi kullaniciDogrula(int hesapNumarasi, int sifre) {
        MusteriHesabi musteriHesabi =null;

        System.out.println("banka bilgi sistemi  kullanıcıyı doğruluyor...");
        Araclar.bekle(2000);
        System.out.println("veritabanına bağlandı (sanal veritabanı yönetim sistemi) ve kullanıcıyı sorguluyor...");
        Araclar.bekle(2000);
        if(hesapNumarasi==2 && sifre==2)
            musteriHesabi = new MusteriHesabi(hesapNumarasi, 1000, "Zeynep", "Gökdoğan");
        return musteriHesabi;
    }

    @Override
    public void hesapGuncelle(MusteriHesabi musteriHesabi) {
        System.out.println("banka bilgi sistemi hesabı güncelledi...");
    }
}
