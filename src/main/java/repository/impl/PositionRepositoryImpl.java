package repository.impl;

import domain.Position;
import repository.PositionRepository;
import java.util.HashMap;
import java.util.Map;

/*
 * PositionRepository implementation
 * Author:Author: (Ona-Odwa Faku) (222878746)
 */
public class PositionRepositoryImpl implements PositionRepository {
    private static PositionRepositoryImpl instance = null;
    private Map<String, Position> positions;

    private PositionRepositoryImpl() {
        this.positions = new HashMap<>();
    }

    public static synchronized PositionRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PositionRepositoryImpl();
        }
        return instance;
    }

    @Override
    public Position create(Position position) {
        positions.put(position.getPositionId(), position);
        return position;
    }

    @Override
    public Position read(String positionId) {
        return positions.get(positionId);
    }

    @Override
    public Position update(Position position) {
        positions.put(position.getPositionId(), position);
        return position;
    }

    @Override
    public boolean delete(String positionId) {
        return positions.remove(positionId) != null;
    }
}

