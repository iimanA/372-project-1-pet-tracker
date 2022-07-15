package project2.domain;

import java.util.ArrayList;
import java.util.Map;

public interface IDataIO {
    Map<String, Shelter> convert (String path);
    void dataExport (Map<String, Shelter> shelterList);
}
