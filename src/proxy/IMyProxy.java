package proxy;


public interface IMyProxy {

    void setName(String name);

    Integer setAge(int age); // why if here int setAge(int age) we catch NullPointerException?

    void howAreYou(String how);

}
