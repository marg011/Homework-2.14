package pro.sky.skyprospringmyarraylist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayStringList implements StringList {

    private String[] strings;

    public ArrayStringList() {
        this.strings = new String[0];
    }

    @Override
    public String add(String item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        String[] temp = strings;
        strings = new String[temp.length + 1];
        System.arraycopy(temp, 0, strings, 0, temp.length);
        strings[strings.length-1] = item;
        return strings[strings.length-1];
    }

    @Override
    public String add(int index, String item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        if (index > strings.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String[] firstPart = Arrays.copyOfRange(strings, 0, index);
        String[] secondPart = Arrays.copyOfRange(strings, index, strings.length);
        strings = new String[firstPart.length + secondPart.length + 1];
        System.arraycopy(firstPart, 0, strings, 0, firstPart.length);
        strings[index] = item;
        System.arraycopy(secondPart, 0, strings, index + 1, secondPart.length);
        return strings[index];
    }

    @Override
    public String set(int index, String item) {
        if (item == null){
            throw new IllegalArgumentException();
        }
        if (index > strings.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        strings[index] = item;
        return strings[index];
    }

    @Override
    public String remove(String item) {
        if (!Arrays.stream(strings).anyMatch(x -> item.equals(x))) {
            throw new NoSuchElementException();
        }
        int ind = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == item) {
                ind = i;
                break;
            }
        }

        return remove(ind);
    }

    @Override
    public String remove(int index) {
        if (index > strings.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        String item = strings[index];

        String[] firstPart = Arrays.copyOfRange(strings, 0, index);
        String[] secondPart = Arrays.copyOfRange(strings, index + 1, strings.length);
        strings = new String[firstPart.length + secondPart.length];
        System.arraycopy(firstPart, 0, strings, 0, firstPart.length);
        System.arraycopy(secondPart, 0, strings, index, secondPart.length);
        return item;
    }

    @Override
    public boolean contains(String item){
        return Arrays.stream(strings).anyMatch(x -> item.equals(x));
    }
    @Override
    public int indexOf(String item){
        if (!Arrays.stream(strings).anyMatch(x -> item.equals(x))) {
            return -1;
        }
        int ind = 0;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i] == item) {
                ind = i;
                break;
            }
        }
        return ind;
    }
    @Override
    public int lastIndexOf(String item){
        if (!Arrays.stream(strings).anyMatch(x -> item.equals(x))) {
            return -1;
        }
        int ind = 0;
        for (int i = strings.length-1; i >= 0; i--) {
            if (strings[i] == item) {
                ind = i;
                break;
            }
        }
        return ind;
    }

    public String get(int index) {
        if (index > strings.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return strings[index];
    }
    @Override
    public boolean equals(StringList otherList){
        return Arrays.equals(strings, otherList.toArray());
    }
    @Override
    public int size() {
        return strings.length;
    }
    @Override
    public boolean isEmpty() {
        if (strings.length == 0) {
            return true;
        } else return false;
    }
    @Override
    public void clear() {
        strings = new String[0];
    }
    @Override
    public String[] toArray(){
        return strings;
    }


}
