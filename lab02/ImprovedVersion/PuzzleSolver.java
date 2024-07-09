package ImprovedVersion;

import java.util.*;

public class PuzzleSolver {
    private Character[][] soup;
    private Map<String, List<Pair>> wordsPositions = new HashMap<String, List<Pair>>();
    private Map<String, Direction> wordsDirections = new HashMap<String, Direction>();

    public PuzzleSolver(Character[][] soup) {
        this.soup = soup;
    }


    public Map<String, List<Pair>> getWordsPositionsMap() {return wordsPositions;}
    public Map<String, Direction> getWordsDirectionsMap() {return wordsDirections;} 

    public boolean[][] findTarget(ArrayList<String> words) {
        boolean[][] booleanSolvedSoup = new boolean[soup.length][soup.length];
        // "target": palavra na lista "words" a ser procurada
        List<String> targetsList;

        // Percorrer todas as letras do puzzle
        for (int i = 0; i < this.soup.length; i++) {
            for (int j = 0; j < this.soup.length; j++) {
                // Verificar se a letra atual é a primeira de alguma das palavras (retorna null se não for)

                targetsList = checkWhichWordMatches(soup[i][j], wordsToUpper(words));

                for (String target : targetsList) {
                    if (target != null) {
                        Pair firstCharCoords = new Pair(i, j);
                        List<Pair> positions = new ArrayList<Pair>();   // Array que conterá as posições de "target" na sopa
    
                        positions = findWord(firstCharCoords, null, target, positions);
                        
                        if (positions != null) {
                            if (wordsPositions.containsKey(target)) {
                                System.err.println("A palavra " + target + " aparece mais do que uma vez na sopa de letras");
                                System.exit(1);
                            } else {
                                wordsPositions.put(target, positions);
                            }
                        }
                    }
                }
            }
        }

        if (wordsPositions.size() != words.size()) {
            System.err.println("Nem todas as palavras foram encontradas na sopa de letras");
            System.exit(1);
        }

        for (Map.Entry<String, List<Pair>> entry : wordsPositions.entrySet()) {
            for (Pair pair : entry.getValue()) {
                booleanSolvedSoup[pair.getX()][pair.getY()] = true;
            }
        }

        return booleanSolvedSoup;
    }


    // Método que encontra as posições da palavra "target" na matriz
    public List<Pair> findWord(Pair firstCharCoords, Direction direction, String target, List<Pair> positions) {

        // Situação limite
        if (target.length() <= 1) {   
            positions.add(firstCharCoords); // Adicionar coordenadas da última letra
            return positions;
        }

        List<Pair> positionsAux = new ArrayList<Pair>();

        positions.add(firstCharCoords); // adicionar coordenadas do primeiro elemento
        
        // Primeiro caso: Ainda não se encontrou a segunda letra (direction é desconhecida - null)
        if (direction == null) { 
            for (Direction dir : Direction.values()) {
                Pair nextPosition = getNextPosition(firstCharCoords, dir);
                if (positionValid(nextPosition) && (target.charAt(1) == getCharAt(nextPosition))) {
                    // Encontrou uma direção válida para continuar a procura

                    if ((positionsAux = findWord(nextPosition, dir, target.substring(1), positions)) == null) { // Se o bloco 'else' (do primeiro 'if') abaixo retornar null, quero que continue a procura nas restantes direções
                        positions.subList(1, positions.size()).clear(); // Eliminar tudo o que foi adicionado, tirando o primeiro elemento
                        continue;
                    }    
                } 

                if (positions.size() == target.length()) {
                    wordsDirections.put(target, dir);
                    return positionsAux;
                }    
            }
            if (positionsAux == null || positionsAux.isEmpty())
                return null;
        } else {
            switch (direction) {
                case Direction.DIR:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {                
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.DIRBAIXO:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.DIRCIMA:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }
                case Direction.CIMA:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.BAIXO:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.ESQ:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.ESQBAIXO:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }    
                case Direction.ESQCIMA:
                    if (positionValid(getNextPosition(firstCharCoords, direction)) && target.charAt(1) == getCharAt(getNextPosition(firstCharCoords, direction))) {
                        return findWord(getNextPosition(firstCharCoords, direction), direction, target.substring(1), positions);
                    } else {
                        return null;
                    }
            }
        }
        return null;
    }


    public List<String> checkWhichWordMatches(Character character, ArrayList<String> words) {
        List<String> wordsMatch = new ArrayList<String>();
        for (String word : words) {
            if (character == word.charAt(0))
                wordsMatch.add(word);
        }
        return wordsMatch;
    }


    // Método para verificar se a posição é válida na sopa de letras
    public boolean positionValid(Pair coords) {
        if (coords.getX() >= this.soup.length || coords.getY() >= this.soup.length || coords.getX() < 0 || coords.getY() < 0)
            return false;
        return true;    
    }


    public char getCharAt(Pair coords) {
        return soup[coords.getX()][coords.getY()];
    }


    public Pair getNextPosition(Pair coords, Direction direction) {
        int x = coords.getX();
        int y = coords.getY();
        switch (direction) {
            case Direction.DIR:
                return new Pair(x, y + 1);   // else..  tratar aqui no caso de não ser igual ou nao ser posição valida, significando que a palavra ainda não foi encontrada (voltar ao inicio mas mudando a direção) 
                
            case Direction.DIRBAIXO:
                return new Pair(x + 1, y + 1);    
                
            case Direction.DIRCIMA:
                return new Pair(x - 1, y + 1);
                
            case Direction.CIMA:
                return new Pair(x - 1, y);
                
            case Direction.BAIXO:
                return new Pair(x + 1, y);    
                
            case Direction.ESQ:
                return new Pair(x, y - 1);    
                
            case Direction.ESQBAIXO:
                return new Pair(x + 1, y - 1);    
                
            case Direction.ESQCIMA:
                return new Pair(x - 1, y - 1);  
            default:
                return null;      
        }
    }


    public String wordsPositionsToString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, List<Pair>> entry : wordsPositions.entrySet()) {
            sb.append(String.format("%s : ", entry.getKey()));
            for (Pair pair : entry.getValue()) 
                sb.append(String.format("(%d, %d) ", pair.getX(), pair.getY()));
            sb.append("\n");
        }
        return sb.toString();
    }


    public ArrayList<String> wordsToUpper(ArrayList<String> words) {
        ArrayList<String> wordsUpper = new ArrayList<String>();
        for (String word : words)
            wordsUpper.add(word.toUpperCase());
        return wordsUpper;    
    }

}
