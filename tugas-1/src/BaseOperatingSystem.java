public abstract class BaseOperatingSystem implements OperatingSystem {
  public void boot() {
    System.out.println(this.getName() + " operating system is booted");
  }

  public void install() {
    System.out.println("Installing " + this.getName() + " Os");
    System.out.println(this.getName() + " Successfully installed");
  }
}
