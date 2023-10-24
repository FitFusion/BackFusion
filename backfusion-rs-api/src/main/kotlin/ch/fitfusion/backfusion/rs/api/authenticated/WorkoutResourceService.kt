package ch.fitfusion.backfusion.rs.api.authenticated

import ch.fitfusion.backfusion.api.common.dtos.ValidationResult
import ch.fitfusion.backfusion.api.workout.dtos.WorkoutDTO
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByAdmin
import ch.fitfusion.backfusion.auth.rbac.annotations.AccessibleByUser
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/authenticated/workout")
@Tag(name = "Anonymous Account Service")
interface WorkoutResourceService {

    @PostMapping
    @AccessibleByUser
    fun createWorkout(@RequestBody workoutDTO: WorkoutDTO): ResponseEntity<WorkoutDTO>

    @PostMapping("/validate")
    @AccessibleByUser
    fun validateWorkout(@RequestBody workoutDTO: WorkoutDTO): ResponseEntity<ValidationResult>

    @GetMapping("/{id}")
    @AccessibleByUser
    fun getWorkout(@PathVariable id: Long): ResponseEntity<WorkoutDTO>

    @PutMapping
    @AccessibleByUser
    fun updateWorkout(@RequestBody workoutDTO: WorkoutDTO): ResponseEntity<WorkoutDTO>

    @DeleteMapping("/{id}")
    @AccessibleByUser
    fun deleteWorkout(@PathVariable id: Long): ResponseEntity<ValidationResult>

    @GetMapping("/for-account/{account-id}")
    @AccessibleByAdmin
    fun getAllWorkoutsForAccount(@PathVariable("account-id") accountId: Long): ResponseEntity<List<WorkoutDTO>>

    @GetMapping("/for-account")
    @AccessibleByUser
    fun getAllWorkoutsForAccount(): ResponseEntity<List<WorkoutDTO>>
}
