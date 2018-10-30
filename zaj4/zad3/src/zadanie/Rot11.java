package zadanie;


public class Rot11 implements Algorithm{
    int constans;
    @Override
    public String crypt(String in){
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            constans = in.charAt(i);
            constans += 11;
            if(constans > 122){
                constans = constans - 26;
            }
            else if(constans < 108 && constans > 90){
                constans = constans - 26;
            }
            wynik.append((char) constans);
        }
        return wynik.toString();
    };
    @Override
    public String decrypt(String in){
        StringBuilder wynik = new StringBuilder();
        for (int i = 0; i < in.length(); i++) {
            constans = in.charAt(i);
            constans -= 11;
            if(constans < 97 && constans > 86){
                constans = constans + 26;
            }
            else if( constans < 65){
                constans = constans + 26;
            }
            wynik.append((char) constans);
        }
        return wynik.toString();
    };



}
