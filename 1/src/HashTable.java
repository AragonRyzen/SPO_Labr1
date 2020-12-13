public class HashTable {

    //������ ��� �������� ���������
    private Item[] table;

    //������ �������
    private int size;

    //�������� �����������, ������� ������� ��������� ������� ������� �������
    public HashTable(int size) {
        this.size = size;
        table = new Item[size];
    }

    //������� ��������� ���� �����
    private int makehashSR(String word)
    {
        int hash = 0;

        for(int i = 0; i < word.length(); i++)
            hash = (31 * hash + word.charAt(i)) % size;

        return hash;
    }

    //������� ���������� ������� � �������� �������������
    public int insertSimpleRehash (String key)
        {
        Item item = new Item(key);
        int count = 0;
        int hash = makehashSR(key);
        while(table[hash] != null)
        {
            hash = (hash + 31) % size;
            count++;
        }
        table[hash] = item;
        return count;
    }

   //����� �������
    public void print()
    {
        for(int i = 0; i < size; i++)
            if(table[i] != null)
                System.out.println(i + " " + table[i].getKey());
    }

   //������� ����� � ���-�������
    public boolean checkSR (String word)
    {
        int hash = makehashSR(word);
        return table[hash].getKey().equals(word)== true;
    }



}
