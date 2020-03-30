/*
 * For quick Java prototyping to see how the language works
 *
 * To compile:
 *
 *         javac HelloWorldApp.java
 *
 * To run:
 *
 *         java HelloWorldApp
 *
 */
class HelloWorldApp {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String a = "literal";
        String b = new String("alloc");

        System.out.println(a);
        System.out.println(b);

        String portals = new String("portala portalb");
        System.out.format("portals.length(): %d\n", portals.length());
        if (portals.length() > 2) {
            System.out.format("Before: `%s`\n", portals);
            portals = portals.substring(0, portals.length() - 1);
            System.out.format("After: `%s`\n", portals);
        }
    }
}