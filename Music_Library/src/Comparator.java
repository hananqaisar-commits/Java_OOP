import java.util.Comparator;

class sortByduration implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {

        return Double.compare(m1.getDurationSeconds(), m2.getDurationSeconds());// Double is wrapper class and compareTo
                                                                                // is defines inside it for compare
                                                                                // precise values

        // return m1.getReleaseYear() - m2.getReleaseYear();//it give accending
    }

}

class sortByreleaseYear implements Comparator<Media> {

    @Override
    public int compare(Media m1, Media m2) {

        if (m1.getReleaseYear() < m2.getReleaseYear())
            return 1;
        if (m1.getReleaseYear() > m2.getReleaseYear())
            return -1;
        return 0;

        // int result = Integer.compare(m2.getReleaseYear(), m1.getReleaseYear());//it
        // also give me decending order if i return result

    }

}