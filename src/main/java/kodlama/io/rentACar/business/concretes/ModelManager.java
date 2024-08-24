package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelsRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelsResponse;
import kodlama.io.rentACar.business.rules.ModelBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

    private ModelRepository modelRepository;
    private ModelMapperService modelMapperService;
    private ModelBusinessRules modelBusinessRules;


    @Override
    public List<GetAllModelsResponse> getAll() {
        List<Model> models = this.modelRepository.findAll();
        List<GetAllModelsResponse> modelResponse = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                        .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
        return modelResponse;
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {

        this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());

        Model model=this.modelMapperService.forRequest().map(createModelRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public GetByIdModelsResponse getById(int id) {
        Model model = this.modelRepository.findById(id).orElseThrow();
        GetByIdModelsResponse getByIdModelsResponse =
                this.modelMapperService.forResponse().map(model,GetByIdModelsResponse.class);

        return getByIdModelsResponse;
    }

    @Override
    public void update(UpdateModelsRequest updateModelsRequest) {
        Model model = this.modelMapperService.forRequest().map(updateModelsRequest,Model.class);
        this.modelRepository.save(model);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }
}
