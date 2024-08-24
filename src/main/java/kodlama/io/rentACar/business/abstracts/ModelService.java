package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelsRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;

import java.util.List;

public interface ModelService {
    List<GetAllModelsResponse> getAll();

    GetByIdModelsResponse getById(int id);

    void add(CreateModelRequest createModelRequest);

    void update(UpdateModelsRequest updateModelsRequest);

    void delete(int id);
}
