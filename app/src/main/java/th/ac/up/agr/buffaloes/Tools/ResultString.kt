package th.ac.up.agr.buffaloes.Tools

class ResultString(val ID: Int) {

    private var dat = ArrayList<String>()

    fun textS(data: ArrayList<String>): ArrayList<String> {

        val str = ArrayList<String>()

        dat = data

        for (i in data.indices) {

            str.add(toStr(ID, i + 1, data[i]))

        }

        return str
    }

    private fun toStr(idF: Int, idB: Int, text: String): String {

        var str = ""

        when (idF) {
            1 -> {
                when (idB) {
                    1 -> {
                        str = text + " เริ่มฉีด GnRH ปริมาตร 2 ml "
                    }
                    2 -> {
                        str = text + " ฉีด PGF2α ปริมาตร 2 ml แล้วคอยตรวจเช็คการเป็นสัด"
                    }
                    3 -> {
                        str = text + " ฉีด GnRH ปริมาตร 2 ml อีกครั้งแล้วทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            2 -> {
                when (idB) {
                    1 -> {
                        str = text + " ฉีด GnRH ปริมาตร 2 ml และสอด CIDR®"
                    }
                    2 -> {
                        str = text + " ถอด CIDR® จากนั้น ฉีด PGF2α ปริมาตร 2 ml"
                    }
                    3 -> {
                        str = dat[1] + " - " + text + " ฉีด GnRH ปริมาตร 2 ml และทำการจับสัดและทำการผสมเทียม"
                    }
                    4 -> {
                        str = "ทำการผสมเทียม"
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