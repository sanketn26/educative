package org.sanket.educative.dp.common;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AlgorithmContainer {
    private Map<String, Algorithm> _algoMap;
    
    public AlgorithmContainer(){
        _algoMap = new HashMap<>();
    }

    public void registerAlgorithm(Algorithm algo){
        _algoMap.put(algo.getName(), algo);
    }

    public List<String> getAlgoNames(){
        return new ArrayList<>(_algoMap.keySet());
    }

    public Algorithm getAlgorithm(String algoName){
        return _algoMap.get(algoName);
    }
}