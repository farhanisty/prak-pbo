class Laptop {
  private OperatingSystem os = null;
  private String name;

  Laptop(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void installOS(OperatingSystem os) {
    os.install();
    this.os = os;
  }

  public void turnOn() {
    System.out.println(this.getName() + " laptop is turned on");
    if(!this.isInstalledOs()) {
      System.out.println("This device does not have an operating system");
    } else {
      this.os.boot();
    }
  }

  public boolean isInstalledOs() {
    return this.os != null;
  }
}
