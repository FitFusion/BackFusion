package ch.fitfusion.backfusion.api.workout.dtos

class WorkoutDTO(
    var id: Long,
    var name: String,
    var description: String,
    var totalDuration: Int,
    var isPublic: Boolean,
    var exercises: List<ExerciseDTO>,
)
