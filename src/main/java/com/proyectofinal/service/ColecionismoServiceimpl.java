package com.proyectofinal.service;

import com.proyectofinal.dao.ColecionismoDao;
import com.proyectofinal.dao.ProductoDao;
import com.proyectofinal.dao.VideojuegoDao;
import com.proyectofinal.domain.Colecionismo;
import com.proyectofinal.domain.Producto;
import com.proyectofinal.domain.Videojuego;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColecionismoServiceimpl implements ColecionismoService{
    @Autowired
    private ColecionismoDao colecionismoDao;
    
    @Autowired
    private ProductoDao productoDao;
    
    @Autowired
    private VideojuegoDao videojuegoDao;

    @Override
    public List<Colecionismo> getColecionismos() {
        return (List<Colecionismo>)colecionismoDao.findAll();
        
    }

    @Override
    public void save(Colecionismo colecionismo) {
        Producto producto = colecionismo.getProducto();
        producto = productoDao.save(producto);
        colecionismo.setProducto(producto);
        Videojuego videojuego = colecionismo.getVideojuego();
        videojuego = videojuegoDao.save(videojuego);
        colecionismo.setVideojuego(videojuego);
        colecionismoDao.save(colecionismo);
    }

    @Override
    public void delete(Colecionismo colecionismo) {
        colecionismoDao.delete(colecionismo);
    }

    @Override
    public Colecionismo getColecionismo(Colecionismo colecionismo) {
        return colecionismoDao.findById(colecionismo.getIdColecionismo()).orElse(null);
    }
}
