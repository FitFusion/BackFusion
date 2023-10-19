package ch.fitfusion.backfusion.workout.services

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.api.workout.services.WorkoutService
import ch.fitfusion.backfusion.workout.repositories.WorkoutRepository
import org.springframework.stereotype.Service

@Service
class WorkoutServiceImpl(
    private val workoutRepository: WorkoutRepository,
    private val exerciseRepository: WorkoutRepository,
//    private val workoutMapper: WorkoutMapper,
//    private val exerciseMapper: WorkoutMapper,
) : WorkoutService {

    override fun createWorkout(workoutDTO: WorkoutDTO): WorkoutDTO {
        TODO("Not yet implemented")
    }

    override fun validateWorkout(workoutDTO: WorkoutDTO): ValidationResult {
        TODO("Not yet implemented")
    }

    override fun getWorkout(id: Long): WorkoutDTO {
        TODO("Not yet implemented")
    }

    override fun updateWorkout(workoutDTO: WorkoutDTO): WorkoutDTO {
        TODO("Not yet implemented")
    }

    override fun deleteWorkout(id: Long): ValidationResult {
        TODO("Not yet implemented")
    }

    override fun getAllWorkoutsForAccount(accountId: Long): List<WorkoutDTO> {
        TODO("Not yet implemented")
    }
}
