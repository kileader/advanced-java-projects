try (PrintWriter output = new PrintWriter(new BufferedWriter(
        new FileWriter("/home/student/output/output.txt")))) {
    output.println("The final line");
} catch(FileNotFoundException fne) {
    System.out.println("Could not find file");
    fne.printStackTrace();
} catch(IOException ioe) {
    System.out.println("Could not close output writer");
    ioe.printStackTrace();
}
