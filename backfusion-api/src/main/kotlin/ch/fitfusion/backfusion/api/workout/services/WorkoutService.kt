package ch.fitfusion.backfusion.api.workout.services

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO

interface WorkoutService {

    fun createWorkout(workoutDTO: WorkoutDTO): WorkoutDTO

    fun validateWorkout(workoutDTO: WorkoutDTO): ValidationResult

    fun getWorkout(id: Long): WorkoutDTO

    fun updateWorkout(workoutDTO: WorkoutDTO): WorkoutDTO

    fun deleteWorkout(id: Long): ValidationResult

    fun getAllWorkoutsForAccount(accountId: Long): List<WorkoutDTO>

    fun getAllWorkoutsForAccount(): List<WorkoutDTO>
}
