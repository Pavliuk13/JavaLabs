public interface ILine {
    int get_start_x();
    int get_start_y();
    int get_finish_x();
    int get_finish_y();
    double get_len();
    void set_start_x(int x);
    void set_start_y(int y);
    void set_finish_x(int x);
    void set_finish_y(int y);
}
