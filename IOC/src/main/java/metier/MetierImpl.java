package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    public void setDao(IDao dao) {
        this.dao = dao;
    }
    @Autowired
    private IDao dao;
    @Override
    public double calcul() {
        return dao.getData() * 2;
    }
}
