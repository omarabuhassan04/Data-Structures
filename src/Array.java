class Array {
    public static int[] arraymaker(int size, String type) {
        int[] array = new int[size];
        if (type.equals("sorted")) {
            for (int i = 0; i < size; i++) {
                array[i] = i;
            }
        } else if (type.equals("random")) {
            for (int i = 0; i < size; i++) {
                array[i] = (int) (Math.random() * size);
            }
        } else if (type.equals("reversely sorted")) {
            for (int i = 0; i < size; i++) {
                array[i] = size - i;
            }
        }
        return array;
    }
}