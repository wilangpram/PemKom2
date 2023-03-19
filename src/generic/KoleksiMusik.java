package generic;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class KoleksiMusik extends AbstractTableModel{
    List<Musik> list = new ArrayList<>();

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0 : return list.get(rowIndex).getFileName();
            case 1 : return list.get(rowIndex).getFileSize();
            default : return "";
        }
    }
    
    public String getColumnName (int column){
        switch(column){
            case 0 : return "JUDUL LAGU";
            case 1 : return "UKURAN";
            default : return "";
        }
    }
    
    public void add (Musik m){
        list.add(m);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    
    public void set(int i, Musik m){
        list.set(i, m);
        fireTableDataChanged();
    }
    
    public void clear(){
        list.clear();
        fireTableDataChanged();
    }
    
    public void remove(int row){
        list.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public Musik get(int row){
        return (Musik) list.get(row);
    }
    
}
