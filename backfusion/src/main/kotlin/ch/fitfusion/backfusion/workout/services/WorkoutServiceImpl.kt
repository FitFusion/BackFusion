package ch.fitfusion.backfusion.workout.services

import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.api.workout.services.WorkoutService
import ch.fitfusion.backfusion.account.repositories.AccountRepository
import ch.fitfusion.backfusion.account.util.AccountUtil
import ch.fitfusion.backfusion.workout.mappers.ExerciseMapper
import ch.fitfusion.backfusion.workout.mappers.WorkoutMapper
import ch.fitfusion.backfusion.workout.repositories.WorkoutRepository
import ch.fitfusion.backfusion.workout.services.validation.WorkoutValidator
import org.springframework.stereotype.Service
import org.springframework.security.access.AccessDeniedException

@Service
class WorkoutServiceImpl(
    private val workoutRepository: WorkoutRepository,
    private val exerciseRepository: WorkoutRepository,
    private val workoutMapper: WorkoutMapper,
    private val exerciseMapper: ExerciseMapper,
    private val validator: WorkoutValidator,
    private val accountUtil: AccountUtil,
    private val accountRepository: AccountRepository
) : WorkoutService {

    override fun createWorkout(workoutDTO: WorkoutDTO): WorkoutDTO {

        val validationResult = validator.validate(workoutDTO)

        val workout = workoutMapper.toEntity(workoutDTO)
        workout.account = accountUtil.getAccountFromContext()

        return workoutMapper.toDTO(workoutRepository.save(workout))
    }

    @Deprecated(message = "Unused")
    override fun validateWorkout(workoutDTO: WorkoutDTO): ValidationResult = ValidationResult.ok()

    override fun getWorkout(id: Long): WorkoutDTO {

        val account = accountUtil.getAccountFromContext()
        val workout = workoutRepository.findByIdAndAccount(id, account)
            .orElse(null) ?: throw AccessDeniedException("Account doesn't belong to object")

        return workoutMapper.toDTO(workout)
    }

    override fun updateWorkout(workoutDTO: WorkoutDTO): WorkoutDTO {
        TODO("Not yet implemented")
    }

    override fun deleteWorkout(id: Long): ValidationResult {

        val account = accountUtil.getAccountFromContext()
        val workout = workoutRepository.findByIdAndAccount(id, account)
            .orElse(null) ?: throw AccessDeniedException("Account doesn't belong to object")

        workoutRepository.delete(workout)

        if (workoutRepository.findById(id).isPresent) {
            throw RuntimeException("") //TODO Better exception
        }

        return ValidationResult.ok()
    }

    override fun getAllWorkoutsForAccount(accountId: Long): List<WorkoutDTO> {

        val account = accountRepository.findById(accountId)
            .orElse(null) ?: return listOf()

        return account.workouts.map { workoutMapper.toDTO(it) }
    }

    override fun getAllWorkoutsForAccount(): List<WorkoutDTO> {

        val workouts = accountUtil.getAccountFromContext().workouts

        return workouts.map { workoutMapper.toDTO(it) }
    }
}
