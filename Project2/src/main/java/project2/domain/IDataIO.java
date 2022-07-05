package project2.domain;

import java.util.ArrayList;

public interface IDataIO {
    ArrayList<Shelter> convert (String path);
    void dataExport (Shelter shelter);
}
