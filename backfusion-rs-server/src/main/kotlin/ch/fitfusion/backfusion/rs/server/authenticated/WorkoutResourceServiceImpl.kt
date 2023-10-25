package ch.fitfusion.backfusion.rs.server.authenticated

import ch.fitfusion.backfusion.api.validation.ValidationResult
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.api.workout.services.WorkoutService
import ch.fitfusion.backfusion.rs.api.authenticated.WorkoutResourceService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
open class WorkoutResourceServiceImpl(
    private val workoutService: WorkoutService,
) : WorkoutResourceService {

    override fun createWorkout(workoutDTO: WorkoutDTO): ResponseEntity<WorkoutDTO> {
        return ResponseEntity.ok(workoutService.createWorkout(workoutDTO))
    }

    override fun validateWorkout(workoutDTO: WorkoutDTO): ResponseEntity<ValidationResult> {
        return ResponseEntity.ok(workoutService.validateWorkout(workoutDTO))
    }

    override fun getWorkout(id: Long): ResponseEntity<WorkoutDTO> {
        return ResponseEntity.ok(workoutService.getWorkout(id))
    }

    override fun updateWorkout(workoutDTO: WorkoutDTO): ResponseEntity<WorkoutDTO> {
        return ResponseEntity.ok(workoutService.updateWorkout(workoutDTO))
    }

    override fun deleteWorkout(id: Long): ResponseEntity<ValidationResult> {
        return ResponseEntity.ok(workoutService.deleteWorkout(id))
    }

    override fun getAllWorkoutsForAccount(accountId: Long): ResponseEntity<List<WorkoutDTO>> {
        return ResponseEntity.ok(workoutService.getAllWorkoutsForAccount(accountId))
    }

    override fun getAllWorkoutsForAccount(): ResponseEntity<List<WorkoutDTO>> {
        return ResponseEntity.ok(workoutService.getAllWorkoutsForAccount())
    }
}
