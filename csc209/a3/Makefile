FLAGS= -Wall -g

all: closest generate_points

closest: closest.o utilities_closest.o serial_closest.o parallel_closest.o
	gcc ${FLAGS} -o $@ $^

generate_points: generate_points.o
	gcc ${FLAGS} -o $@ $^

closest.o: point.h utilities_closest.h serial_closest.h parallel_closest.h
utilities_closest.o: point.h utilities_closest.h
serial_closest.o: point.h utilities_closest.h
parallel_closest.o: point.h utilities_closest.h parallel_closest.h serial_closest.h 

generate_points.o: point.h

%.o: %.c 
	gcc ${FLAGS} -c $< -o $@

.PHONY: clean all

clean:
	-rm *.o closest generate_points