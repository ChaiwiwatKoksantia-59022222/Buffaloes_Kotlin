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
                        str = text + " เริ่มฉีด GnRH"
                    }
                    2 -> {
                        str = text + " ฉีด PGF2α แล้วคอยตรวจเช็คการเป็นสัด"
                    }
                    3 -> {
                        str = text + "ตรวจเช็คการเป็นสัด และผสมเทียมภายใน " + text
                    }
                    else -> {

                    }
                }
            }
            2 -> {
                when (idB) {
                    1 -> {
                        str = text + " เริ่มฉีด GnRH"
                    }
                    2 -> {
                        str = text + " ฉีด PGF2α แล้วคอยตรวจเช็คการเป็นสัด"
                    }
                    3 -> {
                        str = text + " ฉีด GnRH อีกครั้งแล้วทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            3 -> {
                when (idB) {
                    1 -> {
                        str = text + " ฉีด GnRH และสอด CIDR®"
                    }
                    2 -> {
                        str = text + " ถอด CIDR® จากนั้น ฉีด PGF2α"
                    }
                    3 -> {
                        str = dat[1] + " - " + text + " ฉีด GnRH และทำการจับสัดและทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            4 -> {
                when (idB) {
                    1 -> {
                        str = text + " ฉีด GnRH และสอด CIDR®"
                    }
                    2 -> {
                        str = text + " ถอด CIDR® จากนั้น ฉีด PGF2α"
                    }
                    3 -> {
                        str = "ทำการผสมเทียมภายใน 60 ± 6 ชั่วโมง หรือไม่เกิน " + text + " และในวันที่ผสมเทียมทำการฉีด GnRH ร่วมด้วย"
                    }
                    else -> {

                    }
                }
            }
            5 -> {
                when (idB) {
                    1 -> {
                        str = text + " ฉีด GnRH และสอด CIDR®"
                    }
                    2 -> {
                        str = text + " ถอด CIDR® จากนั้น ฉีด PGF2α"
                    }
                    3 -> {
                        str = dat[1] + " - " + text + " ทำการจับสัดและทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            6 -> {
                when (idB) {
                    1 -> {
                        str = text + " ฉีด PGF2α และสอด P-sync"
                    }
                    2 -> {
                        str = text + " ถอด CIDR® จากนั้น ฉีด PGF2α"
                    }
                    3 -> {
                        str = dat[1] + " - " + text + " ทำการจับสัดและทำการผสมเทียม"
                    }
                    else -> {

                    }
                }
            }
            7 -> {
                when (idB) {
                    1 -> {
                        str = text + " เริ่มฉีด GnRH"
                    }
                    2 -> {
                        str = text + " ฉีด PGF2α แล้วคอยตรวจเช็คการเป็นสัด"
                    }
                    3 -> {
                        str = text + " ฉีด GnRH อีกครั้ง"
                    }
                    4 -> {
                        str = text + " ทำการผสมเทียม"
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