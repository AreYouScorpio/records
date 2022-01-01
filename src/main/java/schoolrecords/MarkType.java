package schoolrecords;

public enum MarkType {
    A(5, "excellent"),
    B(4, "very good"),
    C(3, "improvement needed"),
    D(2, "close fail"),
    F(1, "fail");

    String s;
    int i;

    MarkType(int i, String s) {
        this.i=i;
        this.s=s;
    }


    MarkType(String s) {
        this(MarkType.valueOf(s).ordinal(),s);
        this.s = s;
    }

    @Override
    public String toString() {
        return this.s+"("+this.i+")";
    }
}
