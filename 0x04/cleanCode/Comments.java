public class Comments {

    // Copyright (C) 2022 by CleanCode.
    // Released under the terms of the GNU General Public License version 2 or later.

    public Owner getTestcaseOwner(Testcase testcase){}; 

    public Hours getHoursInQuarter(){}; 

    // TODO Este métod deve ser removido
    public void check(){
        return;
    }

    /**
     * <p> This method publishes results based on date.
     * </p>
     * @param date Date from when results should be published.
     * @return List of Result entities.
     * @since 16.0
     */
    public List<Result> publishResults(Date date) {
        // some business logic here
    }
}
