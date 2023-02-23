package old

import org.powbot.api.rt4.Varpbits
@Deprecated("Use Homes.furnitureLeft()")
enum class Data(
    val varb: Int,
    val objectID: IntArray
) {
    DATA_1(
        10554,
        intArrayOf(39981, 39989, 39997, 40002, 40007, 40011, 40083, 40156, 40164, 40171, 40296, 40297)
    ),

    DATA_2(
        10555,
        intArrayOf(39982, 39990, 39998, 40008, 40084, 40089, 40095, 40157, 40172, 40165, 40287, 40293)
    ),

    DATA_3(
        10556,
        intArrayOf(39983, 39991, 39999, 40003, 40012, 40085, 40090, 40096, 40158, 40173, 40166, 40290)
    ),

    DATA_5(
        10557,
        intArrayOf(39984, 39992, 40000, 40086, 40091, 40097, 40159, 40167, 40174, 40288, 40291, 40294)
    ),

    DATA_7(
        10558,
        intArrayOf(39985, 39993, 40009, 40013, 40087, 40092, 40175, 40160, 40168, 40286, 40298, 40004)
    ),

    DATA_8(
        10559,
        intArrayOf(39986, 39994, 40001, 40005, 40010, 40014, 40088, 40093, 40098, 40161, 40169, 40176)
    ),

    DATA_9(
        10560,
        intArrayOf(39987, 39995, 40006, 40015, 40094, 40099, 40162, 40170, 40177, 40292, 40295)
    ),

    DATA_10(
        10561,
        intArrayOf(39996, 39988, 40163, 40289, 40299)
    );

    companion object {
        /**
         * Returns the total of objects left to repair
         */
        fun count(): Int {
            var count = 0
            for (data in values()) {
                val i = Varpbits.value(data.varb, false)
                if (listOf(1, 3, 4).contains(i)) {
                    count++
                }
            }
            return count
        }

//        fun objectsLeft(): MutableList<Int> {
//            val varps: MutableList<Int>? = null
//
//            for (data in values()) {
//
//
////                val list = Li
//
//                val i = Varpbits.value(data.varb, false)
//
//                if (listOf(1, 3, 4).contains(i)) {
//                    varps.add(data.varb)
//                }
//            }
//            return varps
//        }
    }
}