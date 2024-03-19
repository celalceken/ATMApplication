package cc.atm;

public interface IBankaBilgiSistemi {
    public MusteriHesabi kullaniciDogrula(int hesapNumarasi, int sifre);
    public void hesapGuncelle(MusteriHesabi musteriHesabi);

}
