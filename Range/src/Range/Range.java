package Range;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public double getLength() {
        return Math.abs(to - from);
    }

    public boolean isInside(double number) {
        return (number >= from && to >= number);
    }

    @Override
    public String toString() {
        return "[" + from + ", " + to + "]";
    }

    public Range rangeIntersection(Range range) {
        if (this.from >= range.from && this.from <= range.to) {
            if (this.to >= range.from && this.to <= range.to) {
                return this;
            } else {
                return new Range(this.from, range.to);
            }
        } else {
            if (this.to >= range.from && this.to <= range.to) {
                return new Range(range.from, this.to);
            } else {
                if (range.from >= this.from && range.from <= this.to) {
                    return range;
                } else {
                    return null;
                }
            }
        }
    }

    public Range[] rangeUnion(Range range) {
        Range rangeUnion[] = new Range[2];
        if (this.from >= range.from && this.from <= range.to) {
            if (this.to >= range.from && this.to <= range.to) {
                rangeUnion[0] = range;
            } else {
                rangeUnion[0] = new Range(range.from, this.to);
            }
        } else {
            if (this.to >= range.from && this.to <= range.to) {
                rangeUnion[0] = new Range(this.from, range.to);
            } else {
                if (range.from >= this.from && range.from <= this.to) {
                    rangeUnion[0] = this;
                } else {
                    rangeUnion[0] = this;
                    rangeUnion[1] = range;
                }
            }
        }
        return rangeUnion;
    }

    public Range[] rangeComplement(Range range) {
        Range rangeDifference[] = new Range[2];
        if (this.from > range.from && this.from < range.to) {
            if (this.to > range.from && this.to < range.to) {
                return null;
            } else {
                rangeDifference[0] = new Range(range.to, this.to);
            }
        } else {
            if (this.to > range.from && this.to < range.to) {
                rangeDifference[0] = new Range(this.from, range.from);
            } else {
                if (range.from > this.from && range.from < this.to) {
                    rangeDifference[0] = new Range(this.from, range.from);
                    rangeDifference[1] = new Range(range.to, this.to);
                } else {
                    rangeDifference[0] = this;
                }
            }
        }
        return rangeDifference;
    }
}
