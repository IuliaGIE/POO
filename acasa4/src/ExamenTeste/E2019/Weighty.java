package ExamenTeste.E2019;

class Big{ void met(int x){}}
class Heavy extends Big{
    void met(byte b) {}
    //protected void met(int x) throws Exception {}
    public void met(int x) {}
}
public class Weighty extends Heavy{
    //void met(int x) {}
    //String met(int x) { return "hi";}
    //public int met(int x) {return 7;}
    private int met(char c) throws Error{ return 1;}
}
