package pl.sdacademy.proxy;

public class ProxyExample {
	public static void main(String[] args) {
		final Image image1 = new ProxyImage("HiRes_10MB_Photo1");
		final Image image2 = new ProxyImage("HiRes_10MB_Photo2");

		image1.displayImage();
		image1.displayImage();
		image2.displayImage();
		image2.displayImage();
		image1.displayImage();
	}
}
