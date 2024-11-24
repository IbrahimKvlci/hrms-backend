package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.dtos.CandidateCVDto;
import kodlamaio.hrms.entities.concretes.users.Candidate;

public interface CandidateService {
	Result add(Candidate candidate);
	DataResult<List<Candidate>> getAll();
	DataResult<CandidateCVDto> getCandidateCVById(int id);
	DataResult<List<CandidateCVDto>> getAllCandidateCV();
}
