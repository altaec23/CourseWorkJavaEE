package ru.alon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.alon.model.Jedi;
import ru.alon.model.LightSaber;
import ru.alon.repository.JediRepository;
import ru.alon.repository.LightSaberRepository;

import java.util.List;

@Service
public class JediService {

    @Autowired
    private JediRepository jediRepository;

    @Autowired
    private LightSaberRepository lightSaberRepository;

    /**
     * для различных валидаций или действий
     *
     * @return измененный список
     */
    public List<Jedi> findAll() {
        return jediRepository.findAll();
    }

    /**
     * Для отказоустойчивости системы в случае эксепшенов после 1 сохранения в DB
     *
     * @param newJedi новый Jedi
     */
    @Transactional
    public void save(Jedi newJedi) {
        jediRepository.save(newJedi);
        var lightSaber = LightSaber.builder().model("dual").owner(newJedi).build();
        lightSaberRepository.save(lightSaber);
    }
}
