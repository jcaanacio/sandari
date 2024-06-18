package com.sandari.rain.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sandari.rain.libraries.exceptions.RestException;
import com.sandari.rain.libraries.typings.enums.ErrorScope;
import com.sandari.rain.libraries.utils.RaffleInput;
import com.sandari.rain.models.Raffle;
import com.sandari.rain.models.User;
import com.sandari.rain.repositories.RaffleRepository;
import com.sandari.rain.repositories.UserRepository;

@Service
public class RaffleService extends AbstractService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RaffleRepository raffleRepository;

    public List<Raffle> list() {
        return raffleRepository.findAll();
    }

    public Page<Raffle> paginated(int page, int size) {
        PageRequest pageable = PageRequest.of(page, size);
        return raffleRepository.findAll(pageable);
    }

    public Raffle create(Long userId, RaffleInput raffleInput) {
        User user = userRepository.findById(userId).orElse(null);

        if(user == null) {
            throw new RestException("User not found.", 404, ErrorScope.CLIENT);
        }

        Raffle raffle = new Raffle(user, raffleInput.getCategory());
        return raffleRepository.saveAndFlush(raffle);
    }


    public Raffle getByUserId(Long userId) {
        return raffleRepository.findByUserUserId(userId).orElse(null);
    }

    public Raffle update(Long userId, Long raffleId, RaffleInput raffleInput){
        Raffle raffle = raffleRepository.findByUserUserId(userId).orElse(null);

        if(raffle == null) {
            throw new RestException("Raffle not found.", 404, ErrorScope.CLIENT);
        }

        if(raffle.getRaffleId() != raffleId) {
            throw new RestException("Raffle id mismatched.", 404, ErrorScope.CLIENT);
        }

        this.updateNonNullFields(raffleInput, raffle);
        return raffleRepository.saveAndFlush(raffle);
    }

    public void delete(Long raffleId) {
        raffleRepository.deleteById(raffleId);
    }
}
