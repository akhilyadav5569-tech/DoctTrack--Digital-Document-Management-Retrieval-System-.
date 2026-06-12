
class FenwickTree {
    int BIT[];
    int n;

    FenwickTree(int n) {
        this.n = n;
        BIT = new int[n + 1];
    }

    void update(int index, int value) {
        while (index <= n) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }

    public static void main(String args[]) {
        int documents[] = {2, 4, 5, 7, 8};
        int size = documents.length;

        FenwickTree ft = new FenwickTree(size);

        for (int i = 0; i < size; i++) {
            ft.update(i + 1, documents[i]);
        }

        System.out.println("Total documents till index 3 = " + ft.query(3));

        ft.update(2, 3);

        System.out.println("Updated total documents till index 3 = " + ft.query(3));
    }
}

