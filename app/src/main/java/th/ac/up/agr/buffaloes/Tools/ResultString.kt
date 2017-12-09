package th.ac.up.agr.buffaloes.Tools

import android.util.Log

class ResultString(val ID: Int) {

    private var dat = ArrayList<String>()

    fun textS(data: ArrayList<String>,IDs: Int): ArrayList<String> {

        val str = ArrayList<String>()

        dat = data

        for (i in data.indices) {

            if (IDs == 0){
                str.add(toStr(ID, i + 1, ""))
            } else if (IDs == 1){
                str.add(toDateStr(ID, i + 1, data[i]))
            }

        }

        return str
    }

    private fun toStr(idF: Int, idB: Int, text: String): String {

        var str = ""

        when (idF) {
            1 -> {
                when (idB) {
                    1 -> {
                        str = "เริ่มฉีด GnRH ปริมาตร 2 ml "
                    }
                    2 -> {
                        str = "ฉีด PGF2α ปริมาตร 2 ml แล้วคอยตรวจเช็คการเป็นสัด"
                    }
                    3 -> {
                        str = "ฉีด GnRH ปริมาตร 2 ml อีกครั้งแล้วทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            2 -> {
                when (idB) {
                    1 -> {
                        str = "ฉีด GnRH ปริมาตร 2 ml และสอด CIDR®"
                    }
                    2 -> {
                        str = "ถอด CIDR® จากนั้น ฉีด PGF2α ปริมาตร 2 ml"
                    }
                    3 -> {
                        str = "ฉีด GnRH ปริมาตร 2 ml และทำการจับสัดและทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }

            else -> {

            }
        }

        return str

    }

    private fun toDateStr(idF: Int, idB: Int, text: String): String {

        var str = ""

        when (idF) {
            1 -> {
                str = text
            }
            2 -> {
                when (idB) {
                    1 -> {
                        str = text
                    }
                    2 -> {
                        str = text
                    }
                    3 -> {
                        str = dat[1] + " ถึง " + text
                    }
                    else -> {

                    }
                }
            }

            else -> {

            }
        }

        return str

    }

}