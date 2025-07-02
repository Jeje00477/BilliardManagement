package Services;

import DAO.PelangganDAO;
import Model.Pelanggan;

public class PelangganService {
    private PelangganDAO dao = new PelangganDAO();

    public int tambahPelanggan(Pelanggan p) {
        return dao.insertPelanggan(p);
    }
}
