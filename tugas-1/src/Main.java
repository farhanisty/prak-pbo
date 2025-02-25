class Main {
  public static void main(String[] argv) {
    Linux linux = new Linux();
    Windows windows = new Windows();

    Laptop laptopThinkpad = new Laptop("Thinkpad T490");
    Laptop asusRog = new Laptop("Asus ROG");

    laptopThinkpad.installOS(linux);
    laptopThinkpad.turnOn();

    System.out.println("---------------------------");

    asusRog.installOS(windows);
    asusRog.turnOn();
  }
}
