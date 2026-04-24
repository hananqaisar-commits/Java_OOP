interface Payable {

    double getDurationSeconds();// interface methods are public abstract in java without mention it

    default void play() {// these defaults can and cannot override in inmplementation
        System.out.printf("Playing...\n");
    }

}