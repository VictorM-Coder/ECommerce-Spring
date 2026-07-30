package coder.victor.ecommercespring.shared;

public interface Inactivable {
    void inactivate();
    void activate();
    boolean isActive();
}
